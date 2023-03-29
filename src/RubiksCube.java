import java.util.Scanner;

class cube{
   String[] color = new String[6];
   cube(){

      for (int j = 0; j < 3; j++) {
         color[j] = "K";
     };
   }
}
public class RubiksCube {
   
   static cube[][][] cube = new cube[3][3][3];
   
   public RubiksCube() {}

   public static void main(String[] args) throws InterruptedException {
      Boolean shuffel = true;
      String[] arr = {"U+","U-","B+","B-","L+","L-","R+","R-","F+","F-"};
      int loop1 = 30;
      
      // CREATING THE OBJECT ARRAY FOR PIECES

      cube[][][] cube = new cube[3][3][3];
      for(int i=0;i<=2;i++){
         for(int j=0;j<=2;j++){
            for(int k=0;k<=2;k++){
               cube[i][j][k] = new cube();
            }
         }
      }
      // CREATING THE OBJECT ARRAY FOR THE TEMPORARY ASSINGING PIECES

      cube[][][] temp = new cube[3][3][3];
      for(int i=0;i<=2;i++){
         for(int j=0;j<=2;j++){ 
            for(int k=0;k<=2;k++){
               temp[i][j][k] = new cube();
            }
         }
      }
      // ADDING COLORS FOR THE PIECES OF THE CUBE (BUT NOT SHUFFLING)

      // top layer
      for(int i=0;i<=2;i++){
         for(int j=0;j<=2;j++){
            cube[0][i][j].color[0] = "G";
         }
      }
      // bottom layer
      for(int i=0;i<=2;i++){
         for(int j=0;j<=2;j++){
            cube[2][i][j].color[1] = "R";
         }
      }
      // font layer
      for(int i=0;i<=2;i++){
         for(int j=0;j<=2;j++){
            
            cube[i][2][j].color[2] = "B";
            
         }
      }
      // back layer
      for(int i=0;i<=2;i++){
         for(int j=0;j<=2;j++){
            cube[i][0][j].color[3] = "y";
            
         }
      }
      // right layer
      for(int i=0;i<=2;i++){
         for(int j=0;j<=2;j++){
            cube[i][j][2].color[4] = "O";
            
         }
      }
      // left layer
      for(int i=0;i<=2;i++){
         for(int j=0;j<=2;j++){
            cube[i][j][0].color[5] = "W";
            
         }
      }
      while(true){
         Boolean win = true;
         
         Scanner sc1 = new Scanner(System.in); 
         String rInput = "U+";

         while(loop1>0){

            //IF THIS IS THE FIRST LOOP SHUFFEL HAS DONE

            if(shuffel == true){
               rInput = arr[(int) (Math.random()*10)];
            }

            // ELSE USER INPUT IS TAKEN

            else{
               System.out.print("Enter the input: ");  
               rInput = sc1.nextLine();
               rInput = rInput.toUpperCase();
            }

            if(rInput.equals("U+")||rInput.equals("U-")||rInput.equals("B+")||rInput.equals("B-")){

            int constNum;
            if(rInput.equals("U+")||rInput.equals("U-")){
               constNum = 0;
            }
            else{
               constNum = 2;
            }
            // TAKING THE PIECES OBJECTS TO A TEMPORERY OBJECT ARRAY
            for(int i=0;i<=2;i++){
               for(int j=0;j<=2;j++){
                  for(int k=0;k<=5;k++){
                     temp[constNum][i][j].color[k] = cube[constNum][i][j].color[k];
                  }
                   
               }
            }
            
            // FOR CLOCKWISE
            if(rInput.equals("U+")||rInput.equals("B-")){
               // CHANGING PIECES OF THE CUBE FROM THE TEMPORARY ARRAY
               for(int i=0;i<=2;i++){
                  for(int j=0;j<=2;j++){ 
                     for(int k=0;k<=5;k++){  
                        cube[constNum][j][2-i].color[k] = temp[constNum][i][j].color[k];
                     }
                  }
               }
               for(int i=0;i<=2;i++){
                  // CHANGING THE COLORS OF THE UPDATED PIECES
                  cube[constNum][0][i].color[3] = temp[constNum][2-i][0].color[5];
                  cube[constNum][i][2].color[4] = temp[constNum][0][i].color[3];
                  cube[constNum][2][2-i].color[2] = temp[constNum][i][2].color[4];
                  cube[constNum][2-i][0].color[5] = temp[constNum][2][2-i].color[2]; 
               }
            }
            // FOR ANTICLOCKWISE
            if(rInput.equals("U-")||rInput.equals("B+")){
               for(int i=0;i<=2;i++){
                  for(int j=0;j<=2;j++){ 
                     for(int k=0;k<=5;k++){  
                        cube[constNum][2-j][i].color[k] = temp[constNum][i][j].color[k];
                     }
                     
                  }
               }
               for(int i=0;i<=2;i++){
                  cube[constNum][2-i][0].color[5] = temp[constNum][0][i].color[3];
                  cube[constNum][0][i].color[3] = temp[constNum][i][2].color[4];
                  cube[constNum][i][2].color[4] = temp[constNum][2][2-i].color[2];
                  cube[constNum][2][2-i].color[2] = temp[constNum][2-i][0].color[5]; 
               }
            }
         }
         
         else if(rInput.equals("R+")||rInput.equals("R-")||rInput.equals("L+")||rInput.equals("L-")){

            int constNum;
            if(rInput.equals("L+")||rInput.equals("L-")){
               constNum = 0;
            }
            else{
               constNum = 2;
            }
            // TAKING THE PIECES OBJECTS TO A TEMPORERY OBJECT ARRAY
            for(int i=0;i<=2;i++){
               for(int j=0;j<=2;j++){
                  for(int k=0;k<=5;k++){
                     temp[i][j][constNum].color[k] = cube[i][j][constNum].color[k];
                  }
                   
               }
            }
            
            // FOR CLOCKWISE
            if(rInput.equals("L+")||rInput.equals("R-")){
               for(int i=0;i<=2;i++){
                  for(int j=0;j<=2;j++){ 
                     for(int k=0;k<=5;k++){  
                        cube[j][2-i][constNum].color[k] = temp[i][j][constNum].color[k];
                     }
                     
                  }
               }
               for(int i=0;i<=2;i++){
                  cube[0][i][constNum].color[0] = temp[2-i][0][constNum].color[3];
                  cube[i][2][constNum].color[2] = temp[0][i][constNum].color[0];
                  cube[2][2-i][constNum].color[1] = temp[i][2][constNum].color[2];
                  cube[2-i][0][constNum].color[3] = temp[2][2-i][constNum].color[1]; 
               }
            }
            // FOR ANTICLOCKWISE
            if(rInput.equals("L-")||rInput.equals("R+")){
               for(int i=0;i<=2;i++){
                  for(int j=0;j<=2;j++){ 
                     for(int k=0;k<=5;k++){  
                        cube[2-j][i][constNum].color[k] = temp[i][j][constNum].color[k];
                     }
                  }
               }
               for(int i=0;i<=2;i++){
                  cube[2-i][0][constNum].color[3] = temp[0][i][constNum].color[0];
                  cube[0][i][constNum].color[0] = temp[i][2][constNum].color[2];
                  cube[i][2][constNum].color[2] = temp[2][2-i][constNum].color[1];
                  cube[2][2-i][constNum].color[1] = temp[2-i][0][constNum].color[3]; 
               }
            }
         }

         else if(rInput.equals("F+")||rInput.equals("F-")){

            int constNum = 2;
            
            // TAKING THE PIECES OBJECTS TO A TEMPORERY OBJECT ARRAY
            for(int i=0;i<=2;i++){
               for(int j=0;j<=2;j++){
                  for(int k=0;k<=5;k++){
                     temp[i][constNum][j].color[k] = cube[i][constNum][j].color[k];
                  }
                   
               }
            }
            
            // FOR CLOCKWISE
            if(rInput.equals("F+")){
               for(int i=0;i<=2;i++){
                  for(int j=0;j<=2;j++){ 
                     for(int k=0;k<=5;k++){  
                        cube[j][constNum][2-i].color[k] = temp[i][constNum][j].color[k];
                     }
                  }
               }
               for(int i=0;i<=2;i++){
                  cube[0][constNum][i].color[0] = temp[2-i][constNum][0].color[5];
                  cube[i][constNum][2].color[4] = temp[0][constNum][i].color[0];
                  cube[2][constNum][2-i].color[1] = temp[i][constNum][2].color[4];
                  cube[2-i][constNum][0].color[5] = temp[2][constNum][2-i].color[1]; 
               }
            }
            // FOR ANTICLOCKWISE
            if(rInput.equals("F-")){
               for(int i=0;i<=2;i++){
                  for(int j=0;j<=2;j++){ 
                     for(int k=0;k<=5;k++){  
                        cube[2-j][constNum][i].color[k] = temp[i][constNum][j].color[k];
                     }
                     
                  }
               }
               for(int i=0;i<=2;i++){
                  cube[2-i][constNum][0].color[5] = temp[0][constNum][i].color[0];
                  cube[0][constNum][i].color[0] = temp[i][constNum][2].color[4];
                  cube[i][constNum][2].color[4] = temp[2][constNum][2-i].color[1];
                  cube[2][constNum][2-i].color[1] = temp[2-i][constNum][0].color[5]; 
               }
            }
         }
         else{
            System.out.println("Please enter a valid input.");
         }
         loop1--;
      }

      loop1 = 1;
      shuffel = false;

      // DISPLAY THE CUBE

         //      TOP
         //LEFT  FONT   RIGHT   BACK
         //      BOTTOM

         for (int i = 0; i < 3; i++) {
            System.out.print("       ");
            for (int j = 0; j < 3; j++) {
                
                System.out.print(cube[0][i][j].color[0] + " ");
            }
            System.out.println();
         }
         System.out.println();
         for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
               System.out.print(cube[i][j][0].color[5] + " ");
            }
            System.out.print(" ");
            
               for (int k = 0; k < 3; k++) {
                   System.out.print(cube[i][2][k].color[2] + " ");
               }
               System.out.print(" ");
               for (int l = 0; l < 3; l++) {
                  System.out.print(cube[i][2-l][2].color[4] + " ");
               }
               System.out.print(" ");
               for (int m = 0; m < 3; m++) {
                  System.out.print(cube[i][0][2-m].color[3] + " ");
               }
               System.out.println();
         }
         System.out.println();
         for (int i = 0; i < 3; i++) {
            System.out.print("       ");
            for (int j = 0; j < 3; j++) {
                
               System.out.print(cube[2][2-i][j].color[1] + " ");
            }
            System.out.println();
         }

         // checking if the game has won
         int num = 1;
         for (int i = 0; i < 3; i++) {
               for (int n = 1; n < 3; n++) {
                  if(cube[0][i][n].color[0] != cube[0][i][n-1].color[0]){
                     win = false;
                     num = 0;
                     break;
                  }
               }
               for (int j = 1; j < 3; j++) {
                  if(cube[i][j][0].color[5] != cube[i][j-1][0].color[5]){
                     win = false;
                     num = 0;
                     break;
                  }
               }
               for (int k = 1; k < 3; k++) {
                  if(cube[i][2][k].color[2] != cube[i][2][k-1].color[2]){
                     win = false;
                     num = 0;
                     break;
                  }
               }
               for (int l = 1; l < 3; l++) {
                  if(cube[i][l][2].color[4] != cube[i][l-1][2].color[4]){
                     win = false;
                     num = 0;
                     break;
                  }
               }
               for (int m = 1; m < 3; m++) {
                  if(cube[i][0][m].color[3] != cube[i][0][m-1].color[3]){
                     win = false;
                     num = 0;
                     break;
                  }
               }
               for (int o = 1; o < 3; o++) {
                  if(cube[2][i][o].color[1] != cube[2][i][o-1].color[1]){
                     win = false;
                     num = 0;
                     break;
                  }
               }
             if(num == 0){
               break;
             }  
         }
         if(win==true){
            System.out.println("Won!");
            break;
         }
         
      }
     
   }
   
}

