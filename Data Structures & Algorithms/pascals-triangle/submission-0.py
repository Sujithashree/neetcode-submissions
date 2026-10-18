class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        triangle = []
        
        for i in range(numRows):
            # Create a row of length (i + 1) initialized with 1s
            row = [1] * (i + 1)
            
            # Calculate interior values using the previous row
            for j in range(1, i):
                row[j] = triangle[i - 1][j - 1] + triangle[i - 1][j]
                
            triangle.append(row)
            
        return triangle