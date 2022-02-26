package com.survivingcodingbootcamp.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Topic {
    @Id
    @GeneratedValue
    private Long topicId;
    private String name;
    @OneToMany(mappedBy = "topic")
    private Collection<Post> posts;

    protected Topic() {
    }

    public Topic(String name) {
        this.name = name;
    }

    public Long getTopicId() {
        return topicId;
    }

    public String getName() {
        return name;
    }

    public Collection<Post> getPosts() {
        return posts;
    }


    @Override
    public String toString() {
        return "Topic{" +
                "id=" + topicId +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topic topic = (Topic) o;

        if (topicId != null ? !topicId.equals(topic.topicId) : topic.topicId != null) return false;
        return name != null ? name.equals(topic.name) : topic.name == null;
    }

    @Override
    public int hashCode() {
        int result = topicId != null ? topicId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
