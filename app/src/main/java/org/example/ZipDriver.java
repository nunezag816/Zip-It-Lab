import java.util.List;
import java.util.HashMap;

public class ZipDriver {
    public static void main(String[] args) {
        List<Integer> nums1 = List.of(1, 3, 5, 7);
        List<Integer> nums2 = List.of(2, 4, 6, 8);
        List<Integer> zippedNums = ZipUtils.zip(nums1, nums2);
        System.out.println(zippedNums);

        List<String> colors1 = List.of("Red", "Green", "Blue");
        List<String> colors2 = List.of("White", "Black", "Orange", "Pink", "Fuschia");
        List<String> zippedColors = ZipUtils.zip(colors1, colors2);
        System.out.println(zippedColors); 

        List<String> keys = List.of("White", "Black", "Orange", "Pink");
        List<Integer> values = List.of(1, 3, 5, 7);
        HashMap<String, Integer> colorMap = ZipUtils.hashmapify(keys, values);
        System.out.println(colorMap);
    }
}
