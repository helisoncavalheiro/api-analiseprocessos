package br.com.helison.core.models.redmine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "issues", schema = "public")
@Getter
@Setter
public class Issue extends PanacheEntity {

    // Tracker id (FK) - Tipo de tarefa
    @ManyToOne
    @JoinColumn(name = "tracker_id")
    private Tracker trackerId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    // Assunto da tarefa
    @Column(name = "subject")
    private String subject;

    // Descrição da tarefa
    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private Date dueDate;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusId;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id") 
    private User assignedTo;
    
    /* TODO: Transform to FK */
    /*
     * @Column(name = "priority_id") private Integer priorityId;
     */

    /* TODO: Transform to FK */
    /*
     * @Column(name = "fixed_version_id") private Integer fixedVersionId;
     */

    /* TODO: Transform to FK */
    /*
     * @Column(name = "author_id") private Integer authorId;
     */

    @Column(name = "lock_version")
    private Integer lockVersion;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_on")
    private Date updatedOn;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "done_ratio")
    private Integer doneRatio;

    @Column(name = "estimated_hours")
    private Long estimatedHours;

    /* TODO: Transform to FK */
    /*
     * @Column(name = "parent_id") private Integer parentId;
     */

    /* TODO: Transform to FK */
    /*
     * @Column(name = "root_id") private Integer rootId;
     */

    @Column(name = "lft")
    private Integer lft;

    @Column(name = "rgt")
    private Integer rgt;

    public static List<Issue> getIssuesByAuthor(String user) {

        List<Long> issuesIds = CustomValue.getIssuesByCustomField(Long.parseLong("2"), user);

        List<Issue> issues = new ArrayList<Issue>();

        for (Long id : issuesIds) {
            issues.add(findById(id));
        }

        return issues;
    }

    public static List<Issue> getOpenIssuesByProject(Long projectId){
        List<Issue> issues = list("project.id = ?1 or project.parentId = ?1 and statusId.isClosed = FALSE", projectId);
        return issues;
    }

    public static List<Issue> getUserInteractions(String userID) throws SQLException {
        List<Issue> issues = new ArrayList<Issue>();

        List<Issue> userCreations = Issue.getIssuesByAuthor(userID);
        List<Journal> journalizedIssues = Journal.list("journalizedType = 'Issue' AND notes like '@" + userID + "%'");

        for (Journal journal : journalizedIssues) {
            Issue journalizedIssue = findById(journal.getJournalizedId());
            if (!issues.contains(journalizedIssue)) {
                issues.add(journalizedIssue);
            }
        }

        for (Issue issue : userCreations) {
            if (!issues.contains(issue)) {
                issues.add(issue);
            }
        }

        return issues;
    }
}