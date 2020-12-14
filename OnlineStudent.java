// **************************************************************************************************
// CLASS: OnlineStudent
// **************************************************************************************************

public class OnlineStudent extends Student {

/*
 * Declaration of boolean instance variable for student tech
 * fee
 */
   private boolean mTechFee;

   public OnlineStudent(String pId, String pFname, String pLname) {

      super( pId, pFname, pLname );

   }

/*
 * Override calcTuition method from super class Student
 * to calculate tuition for an Online student.
 */
   @Override
   public void calcTuition() {

      double t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;

      if ( getTechFee() ) {
         t = t + TuitionConstants.ONLINE_TECH_FEE;
      }
      setTuition( t );
   }

// Accessor method for tech fee
   public boolean getTechFee() {
      return mTechFee;
   }

// Mutator method to set tech fee to true or false
   public void setTechFee(boolean pTechFee) {
      mTechFee = pTechFee;
   }

}