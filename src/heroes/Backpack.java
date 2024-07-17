package heroes;


import enums.Artifact;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private List<Artifact> artifacts = new ArrayList<>();

    public void addArtifact(Artifact artifact) {
        this.artifacts.add(artifact);
    }

    public boolean checkArtifact(Artifact artifact) {
        return artifacts.contains(artifact);
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }
}
