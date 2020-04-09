package br.com.helison.core.models;

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

    /* TODO: Transform to FK */
    /*
     * @Column(name = "project_id") private Integer projectId;
     */

    // Assunto da tarefa
    @Column(name = "subject")
    private String subject;

    // Descrição da tarefa
    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private Date dueDate;

    // TODO: Transform to FK
    /*
     * @Column(name = "category_id") private Integer categoryId;
     */

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusId;

    /* TODO: Transform to FK */
    /*
     * @Column(name = "assigned_to_id") private Integer assignedToId;
     */

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
}