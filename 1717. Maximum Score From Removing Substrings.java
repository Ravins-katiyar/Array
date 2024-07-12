class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        def remove_and_count(s, first, second, points):
            stack = []
            score = 0
            for char in s:
                if stack and stack[-1] == first and char == second:
                    stack.pop()
                    score += points
                else:
                    stack.append(char)
            return "".join(stack), score

        if x > y:
            s, score = remove_and_count(s, "a", "b", x)
            _, score2 = remove_and_count(s, "b", "a", y)
        else:
            s, score = remove_and_count(s, "b", "a", y)
            _, score2 = remove_and_count(s, "a", "b", x)

        return score + score2
