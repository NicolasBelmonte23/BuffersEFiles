package recursao;

public class ArrayBidimencional {
    public static void main(String[] args) {

        int[][] ar = {{-1,1,1},{2,-2,2},{3,3,-3}} ;
        ArrayBidimencional a = new ArrayBidimencional();
        try{
            a.imprimeArrayDiagonal(ar);
        }catch(IllegalArgumentException|MatrixNotPossibleException e){
            e.printStackTrace();
        }
    }

    public void imprimeArrayDiagonal(int[][]bide)throws IllegalArgumentException,MatrixNotPossibleException{
        if(bide == null)throw new IllegalArgumentException();
        if(bide.length != bide[0].length) throw new MatrixNotPossibleException();
        imprimeArrayDiagonal(bide,0);
    }
    private void imprimeArrayDiagonal(int[][]bide,int i){
        if(i < bide.length){
            System.out.println(bide[i][i]);
            imprimeArrayDiagonal(bide,i+1);
        }
    }
}
