class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        R = len(image)
        C = len(image[0])

        base_color = image[sr][sc] 

        visited = set()
        if base_color == color: return image

        def dfs(row: int, col: int, R:int, C:int, base_color:int, color:int):
            visited.add((row, col))
            image[row][col] = color

            # explore neighbors
            for dr, dc in [(0,-1),(-1,0),(0,1),(1,0)]:
                nr = row+dr
                nc = col+dc
                # safe area check?
                if not (0 <= nr < R and 0 <= nc < C) or image[nr][nc] != base_color or (nr, nc) in visited: continue
                dfs(nr, nc, R, C, base_color, color)

        dfs(sr, sc, R, C, base_color, color)
        return image 