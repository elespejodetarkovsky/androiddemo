package com.sxtsoft.restpolloloko;

import com.sxtsoft.restpolloloko.model.Camarero;
import com.sxtsoft.restpolloloko.model.Pedido;
import com.sxtsoft.restpolloloko.model.Producto;

import org.w3c.dom.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("camareros")
    Call<List<Camarero>> getCamareros();

    @GET("productos")
    Call<List<Producto>> getProducto(); //@Path("id") int postId);

    @GET("pedidos")
    Call<List<Pedido>> getPedido(); //(@Query("userId") int userId);

//    @POST("Posts")
//    Call<Post> createPost(@Body Post post);


}