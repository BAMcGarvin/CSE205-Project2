//**************************************************************************************************
// CLASS: Student
//**************************************************************************************************


public abstract class Student implements Comparable<Student> {

    private int mCredits;
    private String mFname;
    private String mId;
    private String mLname;
    private double mTuition;
    

    /**
     * Creates a Student object and initializes the mId, mFname, and mLname instance variables.
     */
    public Student(String pId, String pFname, String pLname) {
        setId(pId);
        setFirstName(pFname);
        setLastName(pLname);
    }

    /**
     * calcTuition() is to be implemented by subclasses of Student.
     */
    public abstract void calcTuition();

    /**
     * The Comparable interface declares one method compareTo() that must be implemented. This
     * method is called from Sorter.keepMoving() to compare the mId fields of two Students.
     *
     * Compares the mId fields of this Student and pStudent. Returns -1 if this Student's mId
     * field is less than pStudent's mId field. Returns 0 if this Student's mId field is equal to
     * pStudent's mId field. Returns 1 if this Student's mId field is greater than pStudent's mId
     * field. The compareTo
     */
    @Override
    public int compareTo(Student pStudent) {
        return getId().compareTo(pStudent.getId());
    }

    /**
     * Accessor method for mCredits.
     */
    public int getCredits() {
        return mCredits;
    }

    /**
     * Accessor method for mFname.
     */
    public String getFirstName() {
        return mFname;
    }

    /**
     * Accessor method for mId.
     */
    public String getId() {
        return mId;
    }

    /**
     * Accessor method for mLname.
     */
    public String getLastName() {
        return mLname;
    }

    /**
     * Accessor method for mTuition.
     */
    public double getTuition() {
        return mTuition;
    }
    
    /**
     * Mutator method for mCredits.
     */
    public void setCredits(int pCredits) {
        mCredits = pCredits;
    }

    /**
     * Mutator method for mFname.
     */
    public void setFirstName(String pFname) {
        mFname = pFname;
    }

    /**
     * Mutator method for mId.
     */
    public void setId(String pId) {
        mId = pId;
    }

    /**
     * Mutator method for mLname.
     */
    public void setLastName(String pLname) {
        mLname = pLname;
    }

    /**
     * Mutator method for mTuition.
     */
    protected void setTuition(double pTuition) {
        mTuition = pTuition;
    }
    
    
}
