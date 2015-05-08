package j2setest;
public class ChannelRouteKBaseFactory{


    //单例

     private static KnowledgeBaseFactory instance = new ChannelRouteKBaseFactory();

     private final static Object lock = new Object();

     private long version = 0L;

     private Object  result = null;

 

   //私有构造函数
   private ChannelRouteKBaseFactory(){
  
    };

 

   public  static KnowledgeBaseFactory getInstance(){    
     return instance;
   }

    public  Object getObject(){

   

    //取参数实际版本号（数据库，或远程等地方）

    long remoteVersion = .... ;

    

   //记录当前线程取得缓存的版本号

    long     localThreadVersion= version;

   //如果缓存尚未更新过本线程取得当前缓存版本号已经过时 ，

  //则进行缓存更新操作，此条件虽在并发控制内，

  //就是为了减少并发时的锁竞争，被称为乐观锁定

 //（言外之意就是认为此时只有本线程访问）

   if(localVersion==0 || localVersion < remoteVersion){

       synchronized (lock){

        //由于是乐观认为是只有本线程访问，实际进行更新时，再进行一次版本的比较

       //比较实际缓存版本与本线程取得版本相同，在证明确实只有本线程访问，

       //则进行更新操作，负责返回最新的版本

         if(this.version==localVersion){

             //更新操作 result=...;

              return result;

          }else{

           return result;

         }