package serialization;

public class Career implements Serializable {
    private static final long serialVersionUID = 1L;
    private String company;
    private int years;

    public Career(String company, int years) {
        this.company = company;
        this.years = years;
    }
}