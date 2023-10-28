package ex2;

import java.io.Serializable;

public class Transcript implements Serializable {
    private String subject;
    private Double score;

    public Transcript(String subject, Double score) {
        this.subject = subject;
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "subject='" + subject + '\'' +
                ", score=" + score +
                '}';
    }
}