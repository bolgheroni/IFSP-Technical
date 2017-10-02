package enrollmentrenovation.business;

import java.util.List;

public class Discipline {

    private int Id;
    private String Name;
    // Relationships
    private List<SchoolClass> Classes;
    private List<CourseStructure> Structure;
    private List<Credits> Credits;
    private List<Restriction> Requirements;
    private List<Restriction> Achievements;

    public Discipline(int Id, String Name, List<SchoolClass> Classes, List<CourseStructure> Structure, List<Credits> Credits, List<Restriction> Requirements, List<Restriction> Achievements) {
        this.Id = Id;
        this.Name = Name;
        this.Classes = Classes;
        this.Structure = Structure;
        this.Credits = Credits;
        this.Requirements = Requirements;
        this.Achievements = Achievements;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public List<SchoolClass> getClasses() {
        return Classes;
    }

    public void setClasses(List<SchoolClass> Classes) {
        this.Classes = Classes;
    }

    public List<CourseStructure> getStructure() {
        return Structure;
    }

    public void setStructure(List<CourseStructure> Structure) {
        this.Structure = Structure;
    }

    public List<Credits> getCredits() {
        return Credits;
    }

    public void setCredits(List<Credits> Credits) {
        this.Credits = Credits;
    }

    public List<Restriction> getRequirements() {
        return Requirements;
    }

    public void setRequirements(List<Restriction> Requirements) {
        this.Requirements = Requirements;
    }

    public List<Restriction> getAchievements() {
        return Achievements;
    }

    public void setAchievements(List<Restriction> Achievements) {
        this.Achievements = Achievements;
    }
    
    
    
}
