/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.query.core.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.Boolean;
import java.lang.String;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.query.core.entity.View.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Sun Sep 02 18:44:14 CST 2018")
public class View_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<View,String> afterCalculateGridScriptText;
    public static volatile SingularAttribute<View,String> afterGridScriptText;
    public static volatile SingularAttribute<View,String> afterGroupGridScriptText;
    public static volatile SingularAttribute<View,String> alias;
    public static volatile ListAttribute<View,String> availableIdentityList;
    public static volatile ListAttribute<View,String> availableUnitList;
    public static volatile SingularAttribute<View,Boolean> cacheAccess;
    public static volatile SingularAttribute<View,String> code;
    public static volatile SingularAttribute<View,String> data;
    public static volatile SingularAttribute<View,String> description;
    public static volatile SingularAttribute<View,Boolean> display;
    public static volatile SingularAttribute<View,Boolean> enableCache;
    public static volatile SingularAttribute<View,String> id;
    public static volatile SingularAttribute<View,String> layout;
    public static volatile SingularAttribute<View,String> name;
    public static volatile SingularAttribute<View,String> query;
    public static volatile SingularAttribute<View,String> type;
}
