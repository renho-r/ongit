package j2setest;
public class ChannelRouteKBaseFactory {


    //����

//     private static KnowledgeBaseFactory instance = new ChannelRouteKBaseFactory();
//
//     private final static Object lock = new Object();
//
//     private long version = 0L;
//
//     private Object  result = null;
//
//
//
//   //˽�й��캯��
//   private ChannelRouteKBaseFactory(){
//
//    };
//
//
//
//   public  static KnowledgeBaseFactory getInstance(){
//     return instance;
//   }
//
//    public  Object getObject(){
//
//
//
//    //ȡ����ʵ�ʰ汾�ţ����ݿ⣬��Զ�̵ȵط���
//
//    long remoteVersion = .... ;
//
//
//
//   //��¼��ǰ�߳�ȡ�û���İ汾��
//
//    long     localThreadVersion= version;
//
//   //���������δ���¹����߳�ȡ�õ�ǰ����汾���Ѿ���ʱ ��
//
//  //����л�����²��������������ڲ��������ڣ�
//
//  //����Ϊ�˼��ٲ���ʱ��������������Ϊ�ֹ�����
//
// //������֮�������Ϊ��ʱֻ�б��̷߳��ʣ�
//
//   if(localVersion==0 || localVersion < remoteVersion){
//
//       synchronized (lock){
//
//        //�������ֹ���Ϊ��ֻ�б��̷߳��ʣ�ʵ�ʽ��и���ʱ���ٽ���һ�ΰ汾�ıȽ�
//
//       //�Ƚ�ʵ�ʻ���汾�뱾�߳�ȡ�ð汾��ͬ����֤��ȷʵֻ�б��̷߳��ʣ�
//
//       //����и��²��������𷵻����µİ汾
//
//         if(this.version==localVersion){
//
//             //���²��� result=...;
//
//              return result;
//
//          }else{
//
//           return result;
//
//         }
}