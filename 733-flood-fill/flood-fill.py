
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        R = len(image)
        C = len(image[0])
        
        # Correctly initialize the visited matrix using a list comprehension
        visited = [[False for _ in range(C)] for _ in range(R)]
        
        start_color = image[sr][sc]

        # Handle the case where the starting color is already the new color
        if start_color == color:
            return image

        self.color_graph(image, sr, sc, R, C, start_color, color, visited)
        return image
        
    def color_graph(self, image, row, col, R, C, start_color, color, visited):
        visited[row][col] = True
        image[row][col] = color
        
        dirs = [[-1,0], [0,1], [1,0], [0, -1]]
        
        for x, y in dirs:
            nrow = row + x
            ncol = col + y
            
            if nrow < 0 or nrow >= R or ncol < 0 or ncol >= C or visited[nrow][ncol]:
                continue

            if image[nrow][ncol] == start_color:
                self.color_graph(image, nrow, ncol, R, C, start_color, color, visited)
        
        
        # image[row][col] = 1
        # visited[row][col] = False