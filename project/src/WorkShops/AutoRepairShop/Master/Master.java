package WorkShops.AutoRepairShop.Master;

import java.util.Objects;

public class Master {

    private String name;
    private Rank rank;
    private String workExperience;
    private String resume;

    public Master(String name, String rank, String workExperience, String resume) {
        this.name = name;
        setRank(rank);
        setResume(resume);
        setWorkExperience(workExperience);
    }

    public void setRank(String rank){
        try {
            this.rank = Rank.valueOf(rank);
        }  catch (IllegalArgumentException e){
            System.out.println("No such rank!");
        }
    }

    public void setWorkExperience(String workExperience) {
        if(!workExperience.equals("")) {
            this.workExperience = workExperience;
        } else{
            this.workExperience = null;
        }
    }

    public void setResume(String resume) {
        if(!resume.equals("")){
            this.resume = resume;
        } else {
            this.resume = null;
        }
    }

    @Override
    public String toString(){
        StringBuilder information = new StringBuilder();
        information.append(name).append(" ")
                   .append(Objects.requireNonNullElse(rank,"no information")).append(" ");
        information.append(Objects.requireNonNullElse(workExperience, "No work experience")).append(" ");
        information.append(Objects.requireNonNullElse(resume, "No resume"));
        return information.toString();
    }
}
