package singleton;

public class SingletonCLass {

    private static  SingletonCLass singletonCLass = null;

    private SingletonCLass(){
        if(singletonCLass != null){
            throw new RuntimeException();  // to protect class form reflection
        }
    }

    public SingletonCLass getInstance(){

        if(singletonCLass == null)
            synchronized (SingletonCLass.class){
                    if(singletonCLass ==null){
                        singletonCLass =new SingletonCLass();
                    }

            }

        return singletonCLass;



    }

    //eg of singleton    logger, DB connections,

    //your protcet from deserization
    protected Object readResolve() {
        return getInstance();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException  {
        throw new CloneNotSupportedException();
    }




}
