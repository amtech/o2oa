/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.bbs.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.String;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.bbs.entity.BBSVoteRecord.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Sun Sep 02 18:43:19 CST 2018")
public class BBSVoteRecord_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<BBSVoteRecord,String> forumId;
    public static volatile SingularAttribute<BBSVoteRecord,String> id;
    public static volatile SingularAttribute<BBSVoteRecord,String> mainSectionId;
    public static volatile SingularAttribute<BBSVoteRecord,String> optionId;
    public static volatile SingularAttribute<BBSVoteRecord,String> optionValue;
    public static volatile SingularAttribute<BBSVoteRecord,String> sectionId;
    public static volatile SingularAttribute<BBSVoteRecord,String> subjectId;
    public static volatile SingularAttribute<BBSVoteRecord,String> votorName;
}
