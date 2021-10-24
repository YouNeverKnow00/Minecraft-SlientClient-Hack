package slientclient.event;

import slientclient.*;

import java.awt.Event;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.logging.log4j.core.net.Priority;

public final class EventManager
{
  private static final Map<Class<? extends Event>, List<MethodData>> REGISTRY_MAP = new HashMap();
  
  public static void register(Object object)
  {
    Method[] declaredMethods;
    int length = (declaredMethods = object.getClass().getDeclaredMethods()).length;
    for (int i = 0; i < length; i++)
    {
      Method method = declaredMethods[i];
      if (!isMethodBad(method)) {
        register(method, object);
      }
    }
  }
  
  public static void register(Object object, Class<? extends Event> eventClass)
  {
    Method[] declaredMethods;
    int length = (declaredMethods = object.getClass().getDeclaredMethods()).length;
    for (int i = 0; i < length; i++)
    {
      Method method = declaredMethods[i];
      if (!isMethodBad(method, eventClass)) {
        register(method, object);
      }
    }
  }
  
  public static void unregister(Object object)
  {
    Iterator localIterator2;
    for (Iterator localIterator1 = REGISTRY_MAP.values().iterator(); localIterator1.hasNext(); localIterator2.hasNext())
    {
      List<MethodData> dataList = (List)localIterator1.next();
      localIterator2 = dataList.iterator(); continue;
    }
    cleanMap(true);
  }
  

  private static void register(Method method, Object object)
  {
    Class<? extends Event> indexClass = (Class<? extends Event>) method.getParameterTypes()[0];
    MethodData data = new MethodData(object, method, ((EventTarget)method.getAnnotation(EventTarget.class)).value());
    if (!data.getTarget().isAccessible()) {
      data.getTarget().setAccessible(true);
    }
    if (REGISTRY_MAP.containsKey(indexClass))
    {
      if (!((List)REGISTRY_MAP.get(indexClass)).contains(data))
      {
        ((List)REGISTRY_MAP.get(indexClass)).add(data);
      }
    }
    else {
      REGISTRY_MAP.put(indexClass, new CopyOnWriteArrayList()
      {
        private static final long serialVersionUID = 666L;
      });
    }
  }
  
  public static void removeEntry(Class<? extends Event> indexClass)
  {
    Iterator<Map.Entry<Class<? extends Event>, List<MethodData>>> mapIterator = REGISTRY_MAP.entrySet().iterator();
    while (mapIterator.hasNext()) {
      if (((Class)((Map.Entry)mapIterator.next()).getKey()).equals(indexClass))
      {
        mapIterator.remove();
        break;
      }
    }
  }
  
  public static void cleanMap(boolean onlyEmptyEntries)
  {
    Iterator<Map.Entry<Class<? extends Event>, List<MethodData>>> mapIterator = REGISTRY_MAP.entrySet().iterator();
    while (mapIterator.hasNext()) {
      if ((!onlyEmptyEntries) || (((List)((Map.Entry)mapIterator.next()).getValue()).isEmpty())) {
        mapIterator.remove();
      }
    }
  }
  
  
  private static boolean isMethodBad(Method method)
  {
    return (method.getParameterTypes().length != 1) || (!method.isAnnotationPresent(EventTarget.class));
  }
  
  private static boolean isMethodBad(Method method, Class<? extends Event> eventClass)
  {
    return (isMethodBad(method)) || (!method.getParameterTypes()[0].equals(eventClass));
  }
  
  private static void invoke(MethodData data, Event argument)
  {
    try
    {
      data.getTarget().invoke(data.getSource(), new Object[] { argument });
    }
    catch (IllegalAccessException localIllegalAccessException) {}catch (IllegalArgumentException localIllegalArgumentException) {}catch (InvocationTargetException localInvocationTargetException) {}
  }
  
  private static final class MethodData
  {
    private final Object source;
    private final Method target;
    private final byte priority;
    
    public MethodData(Object source, Method target, byte priority)
    {
      this.source = source;
      this.target = target;
      this.priority = priority;
    }
    
    public Object getSource()
    {
      return this.source;
    }
    
    public Method getTarget()
    {
      return this.target;
    }
    
    public byte getPriority()
    {
      return this.priority;
    }
  }

    public static final void call(final PacketSent event) {
        List<MethodData> dataList = REGISTRY_MAP.get(event.getClass());

        if (dataList != null) {
                EventStoppable stoppable = null ;

                for (final MethodData data : dataList) {
                    invoke(data, event);

                    if (stoppable.isStopped()) {
                        break;
                    }
                }
            } else {
                for (final MethodData data : dataList) {
                    invoke(data, event);
                }
            }
        }

	private static void invoke(MethodData data, PacketSent event) {
	// TODO Auto-generated method stub
	
	}
    
}
