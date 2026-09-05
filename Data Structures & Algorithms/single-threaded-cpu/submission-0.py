import heapq

class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        # Add index to each task
        tasks = [(enqueue, process, i) for i, (enqueue, process) in enumerate(tasks)]
        tasks.sort()

        heap = []
        result = []

        time = 0
        i = 0
        n = len(tasks)

        while i < n or heap:
            # If no available task, jump to the next enqueue time
            if not heap and time < tasks[i][0]:
                time = tasks[i][0]

            # Add all available tasks to the heap
            while i < n and tasks[i][0] <= time:
                enqueue, process, index = tasks[i]
                heapq.heappush(heap, (process, index))
                i += 1

            # Pick shortest processing time, then smallest index
            process, index = heapq.heappop(heap)

            result.append(index)
            time += process

        return result