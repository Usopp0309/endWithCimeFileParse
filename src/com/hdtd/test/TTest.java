package com.hdtd.test;

public class TTest {

}

/// <summary>
/// ISimpleList 用于创建动态代理，将运行时的IList<>接口转换为静态的ISimpleList接口
/// </summary>
interface ISimpleList
{
    void Add(Object element);
}
