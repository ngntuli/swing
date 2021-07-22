package com.ntuli.model.artifacts;

public class DirectorArtifacts {

    private Artifacts artifacts;

    public void construct(String name, int value){
        artifacts = new Artifacts(name, value);
    }

    public Artifacts getArtifacts() {
        return artifacts;
    }
}
