/*
 * There is a rectangle with left bottom as (0, 0) and right up as (x, y).

There are N circles such that their centers are inside the rectangle.

Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.
 */


import java.util.* ;

public class dfs1{
    
    public static String isValid(int A , int B , int C , int D , int E[] , int F[]){
           
        int rect[][] = new int[A+1][B+1] ;

        for(int i=0 ;i<=A ;i++){
            for(int j=0 ;j<=B ;j++){
                rect[i][j] = 0 ;
            }
        }


        for(int i=0 ;i<=A ;i++){
            for(int j=0 ;j<=B ;j++){
                for(int p=0 ; p<C ;p++){
                    if((E[p]-i)*(E[p]-i) + (F[p]-j)*(F[p]-j) <= D*D){
                        rect[i][j] = -1 ;
                    }
                }
            }
        }

        if(rect[0][0]==-1 || rect[A][B]==-1){
            return "NO" ;
        }

        dfs(0 ,0 , rect) ;

        if(rect[A][B]==1){
            return "YES" ;
        }

        return "NO" ;
    }

    public static void dfs(int i ,int j , int[][] rect){
        rect[i][j] = 1 ;

        int dx[] = new int[]{-1 , 0 , 1 , 0 , -1 , 1 , -1 , 1} ;
        int dy[] = new int[]{0 , -1 , 0 , 1 , -1 , 1 , 1 , -1} ;

        for(int d=0 ;d<dx.length ;d++){
           int x = dx[d] + i ;
           int y = dy[d] + j ;
           
           if(x >= 0 && x < rect.length && 
              y >= 0 && y < rect[0].length && 
              rect[x][y]!=-1 && rect[x][y]!=1 ) {

               dfs(x , y , rect) ;
               
           }

        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in) ;

        int A = sc.nextInt() ;

        int B = sc.nextInt() ;

        int C = sc.nextInt() ;

        int D = sc.nextInt() ;

        int E[] = new int[C] ;

        for(int i=0 ;i<C ;i++){
            E[i] = sc.nextInt() ;
        }

        int F[] = new int[C] ;

        for(int i=0 ;i<C ;i++){
            F[i] = sc.nextInt() ;
        }
        
        System.out.println(isValid(A, B, C, D, E, F)) ;


    }
}
