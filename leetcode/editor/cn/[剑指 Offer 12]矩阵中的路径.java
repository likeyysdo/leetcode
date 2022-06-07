class Solution {
    public boolean exist(char[][] board, String word) {
        if( board == null || board.length == 0 ) return false;
        char[] w = word.toCharArray();
        int xMax = board[0].length;
        int yMax = board.length;
        boolean[][] visit = new boolean[yMax][];
        for( int i = 0 ; i < yMax ; i++){
            visit[i] = new boolean[xMax];
        }

        for( int y = 0 ; y < yMax ; y++){
            for( int x = 0 ; x < xMax ; x++){
                if( judge( board , visit , w , 0 , xMax , yMax , x , y ) )
                    return true;
            }
        }
        return false;
    }
    public boolean judge( char[][] board, boolean[][] visit , char[] w  , int index , int xMax , int yMax ,int x , int y ){
        if( x < 0 || y < 0 || x >= xMax || y >= yMax || visit[y][x] || w[index] != board[y][x] ){
            return false;
        }
        if( index == w.length - 1 ) return true;
        visit[y][x] = true;
        boolean result = judge( board , visit , w , index + 1 , xMax , yMax , x + 1 , y )
                || judge( board , visit , w , index + 1 , xMax , yMax , x , y + 1)
                || judge( board , visit , w , index + 1 , xMax , yMax , x - 1 , y )
                || judge( board , visit , w , index + 1 , xMax , yMax , x , y - 1);
        visit[y][x] = false;
        return result;
    }
}