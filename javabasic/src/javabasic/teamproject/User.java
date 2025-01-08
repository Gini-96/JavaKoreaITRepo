package javabasic.teamproject;

// 기록에 대한 JAVA Bean
public class User {

   
   private String name;
   private String score;
   
   public User () {
   }

   public User(String name, String score) {
      super();
      this.name = name;
      this.score = score;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getScore() {
      return score;
   }

   public void setScore(String score) {
      this.score = score;
   }

    public int getScoreAsInt() {
           try {
               return Integer.parseInt(score);
           } catch (NumberFormatException e) {
               return 0; // 기본값 반환
           }
           
    }
   
   @Override
   public String toString() {
      return "User [name=" + name + ", score=" + score + "]";
   }
   
   
}
