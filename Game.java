package TicTacToe;

import java.util.Scanner;

public class Game {
    int[][] matriz = {{0,0,0},{0,0,0},{0,0,0}};
    public void start(){
        int i = 0;
        Scanner tec = new Scanner(System.in);
         do {
            show();
             int x = 0,y = 0;
             if(i % 2 == 0){
                System.out.println("Player-1 move");
                System.out.print("Escolha a coluna em que jogara:");
                x = tec.nextInt();
                System.out.print("Escolha a linha em que jogara:");
                y = tec.nextInt();
                if(validate(x,y)){
                    add(x,y,1);
                }else{
                    System.out.println("posicao ja ocupada - jogue novamente");
                    i -= 1;
                }

            }else if(i % 2 == 1){
                System.out.println("Player-2 move");
                System.out.print("Escolha a coluna em que jogara:");
                x = tec.nextInt();
                System.out.print("Escolha a linha em que jogara:");
                y = tec.nextInt();
                if(validate(x,y)){
                    add(x,y,2);
                }
                else{
                    System.out.println("posicao ja ocupada - jogue novamente");
                    i -= 1;
                }
            }
             i++;
         } while (win() == 0);
         show();
         if(win() == 1){System.out.println("Player-1 Win");}
         if(win() == 2){System.out.println("Player-2 Win");}
         if(win() == 4){System.out.println("draw");}
        tec.close();
    }
    private void show() {
        for(int i = 0; i < 3 ; i++){
            for(int e = 0; e < 3 ; e++){
                System.out.print(matriz[e][i] + " ");
            }
            System.out.println("");
        }
    }
    public void add(int x, int y, int p){
        if(p == 1){
            matriz[x][y] = 1;
        }
        if(p == 2){
            matriz[x][y] = -1;
        }
    }
    public int win(){
        //linhas e colunas
        int zeroDif = 0;
        for(int i = 0; i < 3; i++){
            int sumColum = 0;
            int sumLine = 0;
          
            for(int e = 0; e < 3; e++){
               sumColum += matriz[e][i];
               sumLine += matriz[i][e];
               if(matriz[e][i] != 0){zeroDif += 1;}
            }
            if(sumColum == 3){return 1;}
            if(sumColum == -3){return 2;}
            if(sumLine == 3){return 1;}
            if(sumLine == -3){return 2;}
            if(zeroDif == 9){return 4;}
        }
        //diagonal esquerda
        if(matriz[0][0] + matriz[1][1] + matriz[2][2] == 3){return 1;}
        if(matriz[0][0] + matriz[1][1] + matriz[2][2] == -3){return 2;}
        //diagonal direita
        if(matriz[2][0] + matriz[1][1] + matriz[0][2] == 3){return 1;}
        if(matriz[2][0] + matriz[1][1] + matriz[0][2] == -3){return 2;}


        return 0;
    }
    public boolean validate(int x, int y){
        return(matriz[x][y] == 0? true:false);
    }
}
