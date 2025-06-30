SELECT * FROM v_pre_tri_data_reponse_candidat LIMIT 10;


SELECT COUNT(*) FROM v_pre_tri_data_reponse_candidat WHERE date_reponse <= date_limite_reponse;
SELECT COUNT(*) FROM v_pre_tri_data_reponse_candidat WHERE ecart_jour <= marge_disponibilite;
SELECT COUNT(*) FROM v_pre_tri_data_reponse_candidat WHERE prix_propose BETWEEN min_prix_propose AND max_prix_propose;