package net.primarycode.justjala.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.dish_row.*
import kotlinx.android.synthetic.main.fragment_customize_dish.*
import net.primarycode.justjala.R
import net.primarycode.justjala.model.Allergens
import net.primarycode.justjala.model.Dishes

class CustomizeDishDialogFragment: DialogFragment() {

    companion object {

        val DISH_INDEX = "DISH_INDEX"
        val DISH_COMMENT = "DISH_COMMENT"
        fun newInstance(dishIndex: Int): CustomizeDishDialogFragment {
            val arguments = Bundle()
            arguments.putInt(DISH_INDEX, dishIndex)
            arguments.putString(DISH_COMMENT, "No changes")

            val dialog = CustomizeDishDialogFragment()
            dialog.arguments = arguments

            return dialog
        }
    }

    val dishIndex by lazy {
        arguments?.getInt(DISH_INDEX,0)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_customize_dish, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ok_btn.setOnClickListener { acceptSettings() }
        cancel_btn.setOnClickListener { cancelSettings() }

        //val dishIndex=arguments?.getInt(DISH_INDEX, 0)


        idImgDishDetail.setImageResource(Dishes[dishIndex!!].photo)
        idDishNameDetail.setText(Dishes[dishIndex!!].name)
        idLongDescriptionDetail.setText(Dishes[dishIndex!!].longDescription)
        val imParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val layoutAlergens = view.findViewById<LinearLayout>(R.id.layoutalergensDetail)
        var imAlergen: ImageView
        for (alergen in Dishes[dishIndex!!].listAllergens) {
            imAlergen = ImageView(view.context)

            when (alergen) {
                Allergens.CEREALES -> imAlergen.setImageResource(R.drawable.alerg_gluten)
                Allergens.HUEVOS -> imAlergen.setImageResource(R.drawable.alerg_huevos)
                Allergens.FRUTOS_CASCARA -> imAlergen.setImageResource(R.drawable.alerg_frutoscascara)
                Allergens.LECHE -> imAlergen.setImageResource(R.drawable.alerg_lacteos)
                Allergens.PESCADO -> imAlergen.setImageResource(R.drawable.alerg_pescado)
                Allergens.SOJA -> imAlergen.setImageResource(R.drawable.alerg_soja)
                Allergens.ALTRAMUCES -> imAlergen.setImageResource(R.drawable.alerg_altramuces)
                Allergens.APIO -> imAlergen.setImageResource(R.drawable.alerg_apio)
                Allergens.CRUSTACEOS -> imAlergen.setImageResource(R.drawable.alerg_crustaceos)
                Allergens.MOLUSCOS -> imAlergen.setImageResource(R.drawable.alerg_moluscos)
                Allergens.MOSTAZA -> imAlergen.setImageResource(R.drawable.alerg_mostaza)
                Allergens.SESAMO -> imAlergen.setImageResource(R.drawable.alerg_sesamo)
                Allergens.CACAHUETES -> imAlergen.setImageResource(R.drawable.alerg_cacahuetes)
            }


            imAlergen.setMaxHeight(120)
            imAlergen.setMaxWidth(120)
            imAlergen.setScaleType(ImageView.ScaleType.FIT_XY)
            imAlergen.setAdjustViewBounds(true)

            if (layoutAlergens != null) {
                layoutAlergens.addView(imAlergen, imParams)
            }
        }
    }

    private fun cancelSettings() {
        // Inidicamos que cancelamos el envío de datos
        targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_CANCELED, null)
        dismiss()
    }

    private fun acceptSettings() {
        // Creamos los datos de regreso, en este caso las unidades elegidas
        val returnIntent = Intent()

        returnIntent.putExtra(DISH_INDEX, dishIndex)
        returnIntent.putExtra(DISH_COMMENT, idDishCommentDetail.text.toString())

        // Lo mismo que en cancel, pero devolviendo datos
        targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, returnIntent)
        dismiss()
    }

}