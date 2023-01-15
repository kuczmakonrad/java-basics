package pl.kuczdev.__work_questions.final_finalize_finally;

public class ExtendingClass extends BasicNonFinalClass{
    private String extendedVersion;

    @Override
    protected void testingOverride() {
        System.out.println("BASIC NON FINAL CLASS - OVERRIDE!");
    }

    public ExtendingClass(String name, int lo, String extendedVersion) {
        super(name, lo);
        this.extendedVersion = extendedVersion;
    }

    public String getExtendedVersion() {
        return extendedVersion;
    }

    public void setExtendedVersion(String extendedVersion) {
        this.extendedVersion = extendedVersion;
    }
}
