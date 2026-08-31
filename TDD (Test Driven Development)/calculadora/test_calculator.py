from calculator import add, substract

def test_add():
    assert add(1,2) == 3
    assert add(0,0) == 0

def test_substract():
    assert substract(2,1) == 1