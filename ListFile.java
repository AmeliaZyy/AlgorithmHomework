import java.io.File;

public class ListFile {
    public static void main(String[] args) {
        deleteDir(new File("d:\\a"));
    }
    //递归遍历文件夹
    public static void listDir(File dir){
        File[] files = dir.listFiles();//记得listfiles返回的是[]这种数据要包起来，利于for最好是用复数写for好区分
        System.out.println(dir.getAbsolutePath());
        if(files!=null&&files.length>0){
            for(File file : files){
                if(file.isDirectory()){//如果是文件夹，
                    listDir(file);//递归回去，继续调用本方法
                }else{
                    System.out.println(file.getAbsolutePath());//一层一层打
                }
            }
        }
            
    }

    //递归删除文件夹,dir是文件夹，file是文件，files是数组哈
    public static void deleteDir(File dir){
        File[] files = dir.listFiles();
        if(files!=null&&files.length>0){
            for(File file: files){
                if(file.isDirectory()){
                    deleteDir(file);//若是文件夹，继续调用本方法。
                }else{
                    //先删文件
                    System.out.println(file.getAbsolutePath()+" will be deleted, executed: "+file.delete());
                }
            }
            //再删文件夹
            System.out.println(dir.getAbsolutePath()+"文件夹也要被删了哦："+dir.delete());
        }
    }
}
