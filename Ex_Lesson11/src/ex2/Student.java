package ex2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Student implements Serializable {
    private String name;
    private List<Transcript> transcripts = new ArrayList<>();
    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(List<Transcript> transcripts) {
        this.transcripts = transcripts;
    }
}
