
//private static List<Integer> longestSuffix(List<Integer> x) {
//    if(x.size() < 2){
//        return x;
//    }
//    List<Integer> tailSuffix = longestSuffix(x.subList(1, x.size()));
//    return return tailSuffix.size() == x.size() - 1 && !tailSuffix.contains(x.get(0)) ? x : tailSuffix;
//}