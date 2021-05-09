package com.mygdx.game.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Jogo extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture[] passaro;
	private Texture fundo;

	private float larguraDispositivo;
	private float alturaDispositivo;

	private int movimentaY=0;
	private int movimentax=0;

    private float variacao= 0;
    private float gravidade = 0;
    private float posicaoInicialVerticalPassaro= 0;


	
	@Override
	public void create () {


		batch = new SpriteBatch();

		//Cria fundo
		fundo=new Texture("fundo.png");

		//Cria sprites de passaro
		passaro=new Texture[3];

		//sprit 1
        passaro[0] = new Texture("passaro1.png");

        //sprit 2
        passaro[1] = new Texture("passaro2.png");

        //sprit 3
        passaro[2] = new Texture("passaro3.png");

        //Ageita a largura da tela
		larguraDispositivo= Gdx.graphics.getWidth();

        //Ageita a altur da tela
		alturaDispositivo= Gdx.graphics.getHeight();

        //Ageita o posicionamento da tela
        posicaoInicialVerticalPassaro= alturaDispositivo/ 2;

	}

	@Override
	public void render () {

		batch.begin();


		//anima o passaro
        if(variacao> 3)variacao= 0;

        //Ativa ao tocar na tela
        boolean toqueTela= Gdx.input.justTouched();
        if(Gdx.input.justTouched())
        {gravidade = -25;}

        //Faz ele pular
        if(posicaoInicialVerticalPassaro> 0 || toqueTela)posicaoInicialVerticalPassaro= posicaoInicialVerticalPassaro-gravidade;

        //Coloca o fundo
		batch.draw(fundo, 0, 0, larguraDispositivo, alturaDispositivo);

		//anima o passaro
        batch.draw(passaro[(int) variacao], 30, posicaoInicialVerticalPassaro);

        //
        variacao+= Gdx.graphics.getDeltaTime() * 10;

		movimentax++;
		movimentaY++;
        gravidade++;
		batch.end();

	}
	
	@Override
	public void dispose () {

	}
}
