/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.collaboration.core.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.String;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.collaboration.core.entity.SMSMessage.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Sun Sep 02 18:43:31 CST 2018")
public class SMSMessage_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<SMSMessage,String> id;
    public static volatile SingularAttribute<SMSMessage,String> message;
    public static volatile SingularAttribute<SMSMessage,String> mobile;
    public static volatile SingularAttribute<SMSMessage,String> person;
}
