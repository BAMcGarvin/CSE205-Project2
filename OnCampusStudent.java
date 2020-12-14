// **************************************************************************************************
// CLASS: OnCampusStudent
// **************************************************************************************************

public class OnCampusStudent extends Student {

/*
 * Declaration of private instance variables for accessor
 * and mutator methods
 */
   private boolean mResident;

   private double  mProgramFee;

   public OnCampusStudent(String pId, String pFname, String pLname) {

      super( pId, pFname, pLname );

   }

/*
 * Override calcTuition method from super class Student
 * to calculate tuition for an On-campus student.
 */
   @Override
   public void calcTuition() {

      double t = 0.0;

      if ( getResidency() ) {
         t = TuitionConstants.ONCAMP_RES_BASE;
      }
      else {
         t = TuitionConstants.ONCAMP_NONRES_BASE;
      }

      t = t + getProgramFee();

      if ( getCredits() > TuitionConstants.MAX_CREDITS ) {
         t = t + (getCredits() - TuitionConstants.MAX_CREDITS)
               * TuitionConstants.ONCAMP_ADD_CREDITS;
      }
      setTuition( t );
   }

// Accessor method to get program fee
   public double getProgramFee() {
      return mProgramFee;
   }

// Mutator method to set program fee
   public void setProgramFee(double pProgramFee) {
      mProgramFee = pProgramFee;
   }

// Accessor method to get student residency status
   public boolean getResidency() {
      return mResident;
   }

// Mutator method to set residency to true or false
   public void setResidency(boolean pResident) {
      mResident = pResident;
   }

}