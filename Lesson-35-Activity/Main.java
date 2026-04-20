class Main {
  public static void main(String[] args)throws Exception {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init()throws Exception{

    CreateList list=new CreateList("CR101.csv");
    Student[] students = list.getStudentArray();

    // add your code below here

  //Challenge 1
    for(int x=0; x< students.length; x++){
      Student student = students[x];
      if(student.gpa<65){
        fail++;
      }
      else{
        pass++;
      }
    }
    print("Students passing:  "+pass);
    print("Students failing:  "+fail);
    
    //Challenge 2
    print("Percentage failing: "+ fail/(double)students.length*100 + " %");
    
    //Challenge 3
    for(int x=0; x< students.length; x++){
      Student student = students[x];
      if(student.findTeacher("Castro R") && student.gpa<65){
        count++;
      }
    }
    print("Number of Castro R's students failing: "+count);
    
    //Challenge 4
    count=0;
    for(int x=0; x< students.length; x++){
      Student student = students[x];
      if(!student.findCourseStartingWith("UL") && student.gpa<65){
        count++;
      }
    }
    print("Number of failing students not taking Music: "+count);
    
    //Challenge 5
    print("Students taking music, but failing:");
    for(int x=0; x< students.length; x++){
      Student student = students[x];
      if(student.findCourseStartingWith("UL") && student.gpa<65){
        print(student.id);
      }
    }
    
    //Challenge 6
    count=0;
    for(int x=0; x< students.length; x++){
      Student student = students[x];
      if( (student.gradeLevel==9 ||
         student.gradeLevel==10 )&&
         student.gpa > 97 ){
        count++;
      }
    }
    print("Number of freshmen and sophomores with GPA over 97: "+count);
    
    //Challenge 7
    count=0;
    for(int x=0; x< students.length; x++){
      Student student = students[x];
      if(student.findTeacher("Porchetta")  &&
        student.findTeacher("Banu")){
        count++;
      }
    }
    print("Number of students with both Banu & Porchetta as teachers: "+count);
    
    //Challenge 8
    int fresh=0,soph=0, junior=0, senior=0;
    for(int x=0; x< students.length; x++){
      Student student = students[x];
      if(student.gradeLevel==9){
        fresh++;
      }
      else if(student.gradeLevel==10){
        soph++;
      }
      else if(student.gradeLevel==11){
        junior++;
      }
      else if(student.gradeLevel==12){
        senior++;
      }
    }
    print("\nTotal freshmen:"+fresh);
    print("Total sophmores:"+soph);
    print("Total juniors:"+junior);
    print("Total seniors:"+senior);
    
    //Challenge 9
    fresh=0; soph=0; junior=0; senior=0;
    for(int x=0; x< students.length; x++){
      Student student = students[x];
      if(student.findTeacher("Porchetta")){
        if(student.gradeLevel==9){
         fresh++;
        }
        else if(student.gradeLevel==10){
          soph++;
        }
        else if(student.gradeLevel==11){
          junior++;
        }
        else if(student.gradeLevel==12){
          senior++;
        }
      }
    }
    print("Porchetta's students by grade level:");
    print("Porchetta's freshmen:"+fresh);
    print("Porchetta's sophmores:"+soph);
    print("Porchetta's juniors:"+junior);
    print("Porchetta's seniors:"+senior);    
    
    
  }







  
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

}