package com.leca.zandiakt.models

import android.icu.math.BigDecimal
import java.time.LocalDateTime

data class Producto(

    var id: Long? = null,
    var nombre: String? = null,
    var descripcion: String? = null,
    var precio: BigDecimal? = null,
    var stock: Int? = null,
    var disponible: Boolean? = null,
    var fechaCreacion: LocalDateTime? = null,
    var talla: Char? = null,
    var imagen: String? = null
)
