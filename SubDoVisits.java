
/*
网站域名 "discuss.leetcode.com" 由多个子域名组成。顶级域名为 "com" ，二级域名为 "leetcode.com" ，最低一级为 "discuss.leetcode.com" 。当访问域名 "discuss.leetcode.com" 时，同时也会隐式访问其父域名 "leetcode.com" 以及 "com" 。

计数配对域名 是遵循 "rep d1.d2.d3" 或 "rep d1.d2" 格式的一个域名表示，其中 rep 表示访问域名的次数，d1.d2.d3 为域名本身。

例如，"9001 discuss.leetcode.com" 就是一个 计数配对域名 ，表示 discuss.leetcode.com 被访问了 9001 次。
给你一个 计数配对域名 组成的数组 cpdomains ，解析得到输入中每个子域名对应的 计数配对域名 ，并以数组形式返回。可以按 任意顺序 返回答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subdomain-visit-count
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

public class SubDoVisits {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(String cpd: cpdomains){
            String[] s = cpd.split(" ");//分开了就是数字和域名啦
            int count = Integer.parseInt(s[0]);//记得把域名前面的计数转成数字哦

            String[] name = s[1].split("\\.");
            String box = "";
            for(int i=name.length-1; i>=0; i--){//这里注意遍历的顺序哦，从后com往前，如果只是用n：name会错的
                if(i==name.length-1){
                    box=name[i]+box;//第一次忘了分情况连com后面都有点点哈哈哈
                }else{
                    box =name[i] + "."+ box;
                }
                if(map.containsKey(box.substring(0,box.length()))){
                    map.put(box.substring(0,box.length()),map.get(box.substring(0,box.length()))+count);
                }else{
                    map.put(box.substring(0,box.length()),count);
                }
                
            }

        }
        for(String a:map.keySet()){
            list.add(map.get(a)+" "+a);
        }
        return list;
    }
}
