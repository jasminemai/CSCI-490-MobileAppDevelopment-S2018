package com.example.jasmine.gitreference_mai;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jasmine on 2/28/2018.
 */

public class GitReference {
    private String command;
    private String example;
    private String explanation;
    private String section;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
