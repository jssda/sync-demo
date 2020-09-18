package pers.jssd.syncdemo.async.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jssd jssdjing@gmail.com
 * @date 2020/9/18 15:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    private Long id;
    private String name;
    private String pwd;

}
