document.addEventListener("DOMContentLoaded",function() {
    console.log("hola")

    const boton = document.getElementById("simbia")
    const outputArea = document.getElementById("outputArea")

    function buttonClick() {

        outputArea.innerHTML = "boton clickeado maxci trola"
        console.log("boton clickeado correctamente")
        alert("hola", "hola mando")
        console.log("hola")
    }

    boton.addEventListener("click", buttonClick)

})