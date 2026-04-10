package leetcode.zhenhua;
import java.util.*;

public class Solution {
    public static int[] commonFootsteps(int fatherPos, int martinPos, int velFather, int steps) {
        int maxF = 0;
        int bestV2 = 1;

        // 1. Store all unique father positions in a Set for O(1) lookup
        Set<Long> fatherPositions = new HashSet<>();
        long fatherStart = (long) fatherPos;
        long fatherEnd = fatherStart + ((long) steps * velFather);

        for (int i = 0; i <= steps; i++) {
            fatherPositions.add(fatherStart + ((long) i * velFather));
        }

        // 2. Collect all "candidate" velocities.
        // Martin lands on a father's step if: martinPos + j*V2 = FatherPos
        // So V2 = (FatherPos - martinPos) / j
        TreeSet<Integer> candidateVelocities = new TreeSet<>();
        candidateVelocities.add(1); // Default minimum velocity

        for (long fPos : fatherPositions) {
            long dist = fPos - martinPos;
            if (dist <= 0) continue;

            // Martin could reach this position in j steps (1 to steps)
            for (int j = 1; j <= steps; j++) {
                if (dist % j == 0) {
                    candidateVelocities.add((int) (dist / j));
                }
            }
        }

        // 3. Test each candidate velocity (TreeSet keeps them sorted)
        for (int v2 : candidateVelocities) {
            int count = 0;
            // Martin's run: how many father's steps does he hit?
            for (int j = 0; ; j++) {
                long currentMartinPos = (long) martinPos + ((long) j * v2);
                if (currentMartinPos > fatherEnd) break;

                if (fatherPositions.contains(currentMartinPos)) {
                    count++;
                }
            }

            // Update if count is better, or equal (to get the highest V2)
            if (count >= maxF && count > 0) {
                maxF = count;
                bestV2 = v2;
            }
        }

        return new int[]{maxF == 0 ? 0 : maxF, bestV2};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int fPos = in.nextInt();
            int mPos = in.nextInt();
            int vF = in.nextInt();
            int s = in.nextInt();

            int[] result = commonFootsteps(fPos, mPos, vF, s);
            System.out.print(result[0] + " " + result[1]);
        }
    }
}
