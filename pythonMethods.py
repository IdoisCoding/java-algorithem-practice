#1
def determinant(matrix):
    if(len(matrix) == 1):
        return matrix[0][0]
    if(len(matrix) == 2):
        return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1]
    sum = 0
    for i in range(len(matrix)):
        if(i % 2 == 0):
            sum += matrix[i][0] * determinant(getMatrixMinor(matrix,i,0))
        else:
            sum -= matrix[i][0] * determinant(getMatrixMinor(matrix,i,0))
            
    return sum

def getMatrixMinor(m,i,j):
    return [row[:j] + row[j+1:] for row in (m[:i]+m[i+1:])]

#2
class PaginationHelper:
    
    # The constructor takes in an array of items and an integer indicating
    # how many items fit within a single page
    def __init__(self, collection, items_per_page):
        self.collection = collection
        self.items_per_page = items_per_page
        
    
    # returns the number of items within the entire collection
    def item_count(self):
        return len(self.collection)
    
    # returns the number of pages
    def page_count(self):
        return (self.item_count() + self.items_per_page - 1) // self.items_per_page
    
    # returns the number of items on the given page. page_index is zero based
    # this method should return -1 for page_index values that are out of range
    def page_item_count(self, page_index):
        if(page_index < 0 or page_index >= self.page_count()):
            return -1
        if (page_index == self.page_count() - 1):
            return self.item_count() % self.items_per_page or self.items_per_page
        return self.items_per_page


            
    
    # determines what page an item at the given index is on. Zero based indexes.
    # this method should return -1 for item_index values that are out of range
    def page_index(self, item_index):
        if(item_index < 0 or item_index >= self.item_count()):
            return -1
        return item_index // self.items_per_pag
