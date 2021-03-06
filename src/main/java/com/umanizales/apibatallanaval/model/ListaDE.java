package com.umanizales.apibatallanaval.model;

import ch.qos.logback.core.joran.action.IADataForComplexProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListaDE implements Serializable
{
    private NodoDE cabeza;
    private int cont;

    public void adicionarNodo(Object dato)
    {
        if(cabeza == null)
        {
            cabeza = new NodoDE(dato);
        }
        else
        {
            //LLamar a mi ayudante y ubicarme en el último
            NodoDE temp = cabeza;
            while(temp.getSiguiente()!=null)
            {
                temp= temp.getSiguiente();
            }
            ///Parado en el ultimo
            temp.setSiguiente(new NodoDE(dato));
            temp.getSiguiente().setAnterior(temp);
        }
        cont++;
    }

    public void adicionarNodoAlInicio(Object dato)
    {
        if(cabeza == null)
        {
            cabeza= new NodoDE(dato);
        }
        else
        {
           NodoDE temp=cabeza;
           temp.setSiguiente(cabeza);
           cabeza.setAnterior(temp);
           cabeza=temp;
        }
        cont++;
    }

    public void eliminarNodoAlInicio(Object dato)
    {
        if(cabeza.getSiguiente()==null)
        {
            cabeza=null;
        }
        else
        {
            NodoDE temp=cabeza;
            temp.setSiguiente(cabeza);
            temp.setAnterior(null);
            cabeza=temp;
        }
        cont--;
    }
}
