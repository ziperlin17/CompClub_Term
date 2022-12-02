<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Places" jsGroup='place'>
    <div class="bbody" style="color: #292929; margin: -330px -320px -320px 0px; z-index: 999; height: 50px"> <h1>Game hall №1</h1> </div>

    <div class = "bbody">
        <img class="imgA1" style="background: #292929" src="/focused/resourses/bg1.png">
        <div>
            <img id="1" class="imgB1" style=" opacity: 0.65;  left: -300px; top: -230px" src="${place1}">
        </div>
        <div>
            <img id="2" class="imgB1"  style="opacity: 0.65; left: -220px; top: -230px" src="${place2}">
        </div>
        <div>
            <img id="3"  class="imgB1" style="opacity: 0.65;  left: -140px; top: -230px" src="${place3}">
        </div>
        <div>
            <img  id="4" class="imgB1" style=" opacity: 0.65; left: -60px; top: -230px" src="${place4}">
        </div>
        <div>
            <img class="imgB1" id="5" style=" opacity: 0.65; left: -300px; top: -170px" src="${place5}">
        </div>
        <div>
            <img class="imgB1" id="6" style="opacity: 0.65; left: -220px; top: -170px" src="${place6}">
        </div>
        <div>
            <img class="imgB1" id="7" style="opacity: 0.65; left: -140px; top: -170px" src="${place7}">
        </div>
        <div>
            <img class="imgB1" id="8" style="opacity: 0.65; left: -60px; top: -170px" src="${place8}">
        </div>


        <div>
            <img class="imgB1" id="9" style="opacity: 0.65; left: -300px; top: -20px" src="${place9}">
        </div>
        <div>
            <img class="imgB1" id="10" style="opacity: 0.65; left: -220px; top: -20px" src="${place10}">
        </div>
        <div>
            <img class="imgB1" id="11" style="opacity: 0.65; left: -140px; top: -20px" src="${place11}">
        </div>
        <div>
            <img class="imgB1" id="12" style="opacity: 0.65; left: -60px; top: -20px" src="${place12}">
        </div>


        <div>
            <img class="imgB1" id="13" style="opacity: 0.65; left: -300px; top: 150px" src="${place13}">
        </div>
        <div>
            <img class="imgB1" id="14" style="opacity: 0.65; left: -220px; top: 150px" src="${place14}">
        </div>
        <div>
            <img class="imgB1" id="15" style="opacity: 0.65; left: -140px; top: 150px" src="${place15}">
        </div>
        <div>
            <img class="imgB1" id="16" style="opacity: 0.65; left: -60px; top: 150px" src="${place16}">
        </div>
        <div>
            <img class="imgB1" id="17" style="opacity: 0.65; left: -300px; top: 210px" src="${place17}">
        </div>
        <div>
            <img class="imgB1" id="18" style="opacity: 0.65; left: -220px; top: 210px" src="${place18}">
        </div>
        <div>
            <img class="imgB1" id="19" style="opacity: 0.65; left: -140px; top: 210px" src="${place19}">
        </div>
        <div>
            <img class="imgB1" id="20" style="opacity: 0.65; left: -60px; top: 210px" src="${place20}">
        </div>

        <div>
            <img class="imgB1" id="21" style="opacity: 0.65; left: 350px; top: 190px" src="${place21}">
        </div>
        <div>
            <img class="imgB1" id="22" style="opacity: 0.65; left: 350px; top: 110px" src="${place22}">
        </div>
        <div>
            <img class="imgB1" id="23" style="opacity: 0.65; left: 350px; top: 30px" src="${place23}">
        </div>
        <div>
            <img class="imgB1" id="24" style="opacity: 0.65; left: 350px; top: -50px" src="${place24}">
        </div>
        <div>
            <img class="imgB1" id="25" style="opacity: 0.65; left: 350px; top: -130px" src="${place25}">
        </div>
        <div>
            <img class="imgB1" id="26" style="opacity: 0.65; left: 350px; top: -210px" src="${place26}">
        </div>

        <div>
            <img class="imgB1" id="27" style="opacity: 0.65; left: 150px; top: 140px" src="${place27}">
        </div>
        <div>
            <img class="imgB1" id="28" style="opacity: 0.65; left: 150px; top: 80px" src="${place28}">
        </div>
        <div>
            <img class="imgB1" id="29" style="opacity: 0.65; left: 150px; top: 20px" src="${place29}">
        </div>
        <div>
            <img class="imgB1" id="30" style="opacity: 0.65; left: 150px; top: -40px" src="${place30}">
        </div>
        <div>
            <img class="imgB1" id="31" style="opacity: 0.65; left: 150px; top: -100px" src="${place31}">
        </div>
        <div>
            <img class="imgB1" id="32" style="opacity: 0.65; left: 150px; top: -160px" src="${place32}">
        </div>

        <div class="bbody">

            <button style="margin-top: 657px" class="countbutton" id="submit">Submit</button>
            <div style="background: #292929; margin-top: 688px" class='count_box'>
                <div class="minus">-hours</div>
                <input id="hourvalue" class='inp_price' type="number" value="1" placeholder="hours"/>
                <div class="plus">+hours</div>
            </div>
        </div>
    </div>

</t:mainLayout>