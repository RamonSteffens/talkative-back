package com.example.talkative1.entity.user.response;

import com.example.talkative1.entity.feeling.Feeling;
import com.example.talkative1.entity.feeling.response.FeelingResponse;
import com.example.talkative1.entity.material.Material;
import com.example.talkative1.entity.material.response.MaterialResponse;
import com.example.talkative1.entity.user.User;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class UserResponse {

    private Integer id;
    private String name;
    private String email;
    private List<MaterialResponse> materials;
    private List<FeelingResponse> feelings;

    public static UserResponse buildUser(User user){
        var userResponse = UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail());

        var materials = user.getMaterials();
        var feelings = user.getFeelings();

        addMaterials(materials, userResponse);
        addFeelings(feelings, userResponse);

        return userResponse.build();
    }
    public static void addMaterials(List<Material> materials, UserResponseBuilder userResponseBuilder){
        if (!materials.isEmpty()){
            var materialsResponse = new ArrayList<MaterialResponse>();
            materials.forEach(material ->
                    materialsResponse.add(MaterialResponse.build(material)));
            userResponseBuilder.materials(materialsResponse);
        }
    }

    public static void addFeelings(List<Feeling> feelings, UserResponseBuilder userResponseBuilder){
        if (!feelings.isEmpty()){
            var feelingsResponse = new ArrayList<FeelingResponse>();
            feelings.forEach(feeling ->
                    feelingsResponse.add(FeelingResponse.build(feeling)));
            userResponseBuilder.feelings(feelingsResponse);
        }
    }

}
