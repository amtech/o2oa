/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.organization.core.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.organization.core.entity.Unit.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Sun Sep 02 18:43:53 CST 2018")
public class Unit_ extends SliceJpaObject_  {
    public static volatile ListAttribute<Unit,String> controllerList;
    public static volatile SingularAttribute<Unit,String> description;
    public static volatile SingularAttribute<Unit,String> dingdingHash;
    public static volatile SingularAttribute<Unit,String> dingdingId;
    public static volatile SingularAttribute<Unit,String> distinguishedName;
    public static volatile SingularAttribute<Unit,String> id;
    public static volatile ListAttribute<Unit,String> inheritedControllerList;
    public static volatile SingularAttribute<Unit,Integer> level;
    public static volatile SingularAttribute<Unit,String> levelName;
    public static volatile SingularAttribute<Unit,String> name;
    public static volatile SingularAttribute<Unit,Integer> orderNumber;
    public static volatile SingularAttribute<Unit,String> pinyin;
    public static volatile SingularAttribute<Unit,String> pinyinInitial;
    public static volatile SingularAttribute<Unit,String> qiyeweixinHash;
    public static volatile SingularAttribute<Unit,String> qiyeweixinId;
    public static volatile SingularAttribute<Unit,String> shortName;
    public static volatile SingularAttribute<Unit,String> superior;
    public static volatile ListAttribute<Unit,String> typeList;
    public static volatile SingularAttribute<Unit,String> unique;
    public static volatile SingularAttribute<Unit,String> zhengwuDingdingHash;
    public static volatile SingularAttribute<Unit,String> zhengwuDingdingId;
}
